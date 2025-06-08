package org.example.linkedIn;

import java.util.List;

public class Profile {
    private String profilePictureUrl;
    private String headline;
    private String summary;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;

//    public Profile(String profilePictureUrl, String headline, String summary) {
//        this.profilePictureUrl = profilePictureUrl;
//        this.headline = headline;
//        this.summary = summary;
//    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addExperiences(Experience experience) {
        experiences.add(experience);
    }

    public void addEducations(Education education) {
        educations.add(education);
    }

    public void addSkills(Skill skill) {
        skills.add(skill);
    }
}
