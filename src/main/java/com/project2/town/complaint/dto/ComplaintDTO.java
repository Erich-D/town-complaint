package com.project2.town.complaint.dto;

public class ComplaintDTO {
    private long complaint_id;
    private String description;
    private String status;
    private long meeting_id;

    public long getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(long complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(long meeting_id) {
        this.meeting_id = meeting_id;
    }
}


