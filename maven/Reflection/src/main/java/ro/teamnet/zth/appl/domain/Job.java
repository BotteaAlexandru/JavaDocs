package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by user on 7/7/2016.
 */
@Table(name = "JOBS")
public class Job {
    @Id(name = "job_id")
    private String id;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "max_salary")
    private Long maxSalary;
    @Column(name = "min_salary")
    private Long minSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (!id.equals(job.id)) return false;
        if (jobTitle != null ? !jobTitle.equals(job.jobTitle) : job.jobTitle != null) return false;
        if (maxSalary != null ? !maxSalary.equals(job.maxSalary) : job.maxSalary != null) return false;
        return minSalary != null ? minSalary.equals(job.minSalary) : job.minSalary == null;

    }
}
