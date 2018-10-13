package com.goodfancier.searchEngine.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Theme implements DomainObject
{
    private String[] tags;
    private Owner owner;
    private Long accepted_answer_id;
    private Boolean is_answered;
    private Integer view_count;
    private Long closed_date;
    private Long protected_date;
    private Integer answer_count;
    private Integer score;
    private String name;

    private DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String[] getTags()
    {
        return tags;
    }

    public void setTags(String[] tags)
    {
        this.tags = tags;
    }

    public Long getAccepted_answer_id()
    {
        return accepted_answer_id;
    }

    public void setAccepted_answer_id(Long accepted_answer_id)
    {
        this.accepted_answer_id = accepted_answer_id;
    }

    public Boolean getIs_answered()
    {
        return is_answered;
    }

    public void setIs_answered(Boolean is_answered)
    {
        this.is_answered = is_answered;
    }

    public Integer getView_count()
    {
        return view_count;
    }

    public void setView_count(Integer view_count)
    {
        this.view_count = view_count;
    }

    public Long getClosed_date()
    {
        return closed_date;
    }

    public void setClosed_date(Long closed_date)
    {
        this.closed_date = closed_date;
    }

    public Long getProtected_date()
    {
        return protected_date;
    }

    public void setProtected_date(Long protected_date)
    {
        this.protected_date = protected_date;
    }

    public Integer getAnswer_count()
    {
        return answer_count;
    }

    public void setAnswer_count(Integer answer_count)
    {
        this.answer_count = answer_count;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public Long getLast_activity_date()
    {
        return last_activity_date;
    }

    public void setLast_activity_date(Long last_activity_date)
    {
        this.last_activity_date = last_activity_date;
    }

    public Long getLast_edit_date()
    {
        return last_edit_date;
    }

    public void setLast_edit_date(Long last_edit_date)
    {
        this.last_edit_date = last_edit_date;
    }

    public Date getCreation_date()
    {
        return creation_date;
    }

    public void setCreation_date(Date creation_date)
    {
        this.creation_date = creation_date;
    }

    public Long getQuestion_id()
    {
        return question_id;
    }

    public void setQuestion_id(Long question_id)
    {
        this.question_id = question_id;
    }

    public String getClosed_reason()
    {
        return closed_reason;
    }

    public void setClosed_reason(String closed_reason)
    {
        this.closed_reason = closed_reason;
    }

    private Long last_activity_date;
    private Long last_edit_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm a z")
    private Date creation_date;

    private Long question_id;
    private String link;
    private String closed_reason;
    private String title;
    private int bounty_amount;
    private String bounty_closes_date;
    private String migrated_from;

    public String getMigrated_from()
    {
        return migrated_from;
    }

    public void setMigrated_from(String migrated_from)
    {
        this.migrated_from = migrated_from;
    }

    public String getBounty_closes_date()
    {
        return bounty_closes_date;
    }

    public void setBounty_closes_date(String bounty_closes_date)
    {
        this.bounty_closes_date = bounty_closes_date;
    }

    public int getBounty_amount()
    {
        return bounty_amount;
    }

    public void setBounty_amount(int bounty_amount)
    {
        this.bounty_amount = bounty_amount;
    }

    public Integer getAnswerCount()
    {
        return answer_count;
    }

    public void setAnswerCount(Integer answerCount)
    {
        this.answer_count = answerCount;
    }

    public Owner getOwner()
    {
        return owner;
    }

    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }
}
