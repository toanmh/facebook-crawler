package facebook;

import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shreevats
 * Date: Jul 31, 2010
 * Time: 6:12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {

    /**
     * Complete name of the user
     */
    private String name;

    /**
     * User id
     */
    private String id;

    /**
     * Description given by the user
     */
    private String aboutMe;

    /**
     * Educational details of the user
     */
    private List<User.Education> education;

    /**
     * User's email
     */
    private String email;

    /**
     * User's gender
     */
    private String gender;

    /**
     * User's interest on facebook
     */
    private List<String> interestedIn;

    /**
     * User's hometown
     */
    private NamedFacebookType hometown;

    /**
     * User's Birthday
     */
    private String birthday;

    /**
     * User's link
     */
    private String link;

    /**
     * User's locale
     */
    private String locale;

    /**
     * User's Location
     */
    private NamedFacebookType location;

    /**
     * User's picture's information
     */
    private String picture;

    /**
     * User's political view
     */
    private String political;

    /**
     * User's relationship status
     */
    private String relationshipStatus;

    /**
     * User's religion's inforamtion
     */
    private String religion;

    /**
     * User's timezone
     */
    private Double timezone;

    /**
     * Type of the user
     */
    private String type;

    /**
     * User's website
     */
    private String website;

    /**
     * Is the user verified?
     */
    private boolean verfied;

    /**
     * Work details furnished by the user
     */
    private List<User.Work> work;


    public UserInfo(User user){

        try{
            setName(user.getName());
        }catch(NullPointerException e){}
        try{
            setAboutMe(user.getAbout());
        }catch(NullPointerException e){}
        try{
            setBirthday(user.getBirthday());
        }catch(NullPointerException e){}
        try{
            setEducation(user.getEducation());
        }catch(NullPointerException e){}
        try{
            setEmail(user.getEmail());
        }catch(NullPointerException e){}
        try{
            setGender(user.getGender());
        }catch(NullPointerException e){}
        try{
            setHometown(user.getHometown());
        }catch(NullPointerException e){}
        try{
            setId(user.getId());
        }catch(NullPointerException e){}
        try{
            setInterestedIn(user.getInterestedIn());
        }catch(NullPointerException e){}
        try{
            setLink(user.getLink());
        }catch(NullPointerException e){}
        try{
            setLocale(user.getLocale());
        }catch(NullPointerException e){}
        try{
            setLocation(user.getLocation());
        }catch(NullPointerException e){}
        try{
            setPicture(user.getPicture());
        }catch(NullPointerException e){}
        try{
            setPolitical(user.getPolitical());
        }catch(NullPointerException e){}
        try{
            setRelationshipStatus(user.getRelationshipStatus());
        }catch(NullPointerException e){}
        try{
            setReligion(user.getReligion());
        }catch(NullPointerException e){}
        try{
            setTimezone(user.getTimezone());
        }catch(NullPointerException e){}
        try{
            setType(user.getType());
        }catch(NullPointerException e){}
        try{
            setVerfied(user.getVerified());
        }catch(NullPointerException e){}
        try{
            setWebsite(user.getWebsite());
        }catch(NullPointerException e){}
        try{
            setWork(user.getWork());
        }catch(NullPointerException e){}

    }

    public void dump(PrintStream out){

        out.println("Name-:-"+name);
        out.println("About-:-"+aboutMe);
        out.println("Birthday-:-"+birthday);
        for(User.Education edu : education){
            out.println("Education-:-"+edu.toString());
        }
        out.println("Email-:-"+email);
        out.println("Gender-:-"+gender);
        out.println("Hometown-:-"+hometown);
        out.println("ID-:-"+id);
        for(String interest : interestedIn){
            out.println("Interest-:-"+interest);
        }
        out.println("Link-:-"+link);
        out.println("Locale-:-"+locale);
        out.println("Location-:-"+location);
        out.println("Picture-:-"+picture);
        out.println("Political-:-"+political);
        out.println("RelationshipStatus-:-"+relationshipStatus);
        out.println("Religion-:-"+religion);
        out.println("Timezone-:-"+timezone);
        out.println("Type-:-"+type);
        out.println("Verified-:-"+verfied);
        out.println("Website-:-"+website);
        for(User.Work wrk : work){
            out.println("Work-:-"+work);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<User.Education> getEducation() {
        return education;
    }

    public void setEducation(List<User.Education> education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(List<String> interestedIn) {
        this.interestedIn = interestedIn;
    }

    public NamedFacebookType getHometown() {
        return hometown;
    }

    public void setHometown(NamedFacebookType hometown) {
        this.hometown = hometown;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public NamedFacebookType getLocation() {
        return location;
    }

    public void setLocation(NamedFacebookType location) {
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Double getTimezone() {
        return timezone;
    }

    public void setTimezone(Double timezone) {
        this.timezone = timezone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isVerfied() {
        return verfied;
    }

    public void setVerfied(boolean verfied) {
        this.verfied = verfied;
    }

    public List<User.Work> getWork() {
        return work;
    }

    public void setWork(List<User.Work> work) {
        this.work = work;
    }

}
