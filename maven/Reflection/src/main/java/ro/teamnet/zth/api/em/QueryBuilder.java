package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by user on 7/7/2016.
 */
public class QueryBuilder {

    private Object tableName;
    private ArrayList<ColumnInfo> queryColumns = new ArrayList<ColumnInfo>();
    private QueryType queryType;
    private ArrayList<Condition> conditions = new ArrayList<Condition>();

    public String getValueFromQuery(Object value) {

        if (value.getClass() == Date.class) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('" + dateFormat.format((Date) value) + "','mm-dd-YYYY'";
        }
        if (value.getClass() == String.class) {
            String s = (String) value;
            return s.substring(s.indexOf("'") + 1, s.indexOf("'"));
        }
        return "";
    }

    public QueryBuilder addCondition(Condition condition) {
        this.conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(ArrayList<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    public String createSelectQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        for (ColumnInfo columnInfo : this.queryColumns) {
            stringBuilder.append(columnInfo.getDbName() + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(" FROM ");
        stringBuilder.append(EntityUtils.getTableName(this.tableName.getClass()));
        if (conditions.size() == 0) {
            stringBuilder.append(";");
            return stringBuilder.toString();
        }

        stringBuilder.append(" WHERE ");
        for (Condition condition : this.conditions) {
            stringBuilder.append(condition.getColumnName() + "=" + condition.getValue().toString() + " and ");
        }
        stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String createDeleteQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE ");
        stringBuilder.append("FROM ");
        stringBuilder.append(EntityUtils.getTableName(this.tableName.getClass()));
        if (conditions.size() == 0) {
            stringBuilder.append(";");
            return stringBuilder.toString();
        }
        stringBuilder.append(" WHERE");
        for (Condition condition : this.conditions) {
            stringBuilder.append(condition.getColumnName() + "=" + getValueFromQuery(condition.getValue()) + " and ");
        }
        stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String createUpdateQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ");
        stringBuilder.append(EntityUtils.getTableName(this.tableName.getClass()));
        stringBuilder.append(" SET ");
        for (ColumnInfo columnInfo : this.queryColumns) {
            stringBuilder.append(columnInfo.getDbName() + "=" + getValueFromQuery(columnInfo.getValue()) + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (conditions.size() == 0) {
            stringBuilder.append(";");
            return stringBuilder.toString();
        }
        stringBuilder.append(" WHERE ");
        for (Condition condition : this.conditions) {
            stringBuilder.append(condition.getColumnName() + "=" + getValueFromQuery(condition.getValue()) + " and ");
        }
        stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String createInsertQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ");
        stringBuilder.append(EntityUtils.getTableName(this.tableName.getClass()));
        stringBuilder.append(" (");
        for (ColumnInfo columnInfo : this.queryColumns) {
            stringBuilder.append(columnInfo.getDbName() + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(") VALUES (");
        for (Condition condition : this.conditions) {
            stringBuilder.append(getValueFromQuery(condition.getValue()) + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(");");

        return stringBuilder.toString();
    }

    public String createQuery() {
        switch (this.queryType) {
            case SELECT:
                return createSelectQuery();
            case DELETE:
                return createDeleteQuery();
            case UPDATE:
                return createUpdateQuery();
            case INSERT:
                return createInsertQuery();
            default:
                return "";
        }
    }

}
