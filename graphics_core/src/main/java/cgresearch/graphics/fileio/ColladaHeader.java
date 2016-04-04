package cgresearch.graphics.fileio;

import java.util.Date;

/**
 * The header information of a Collada file
 *
 * @author: David Asmuth
 */
public class ColladaHeader {
    private String filename;
    private String schemaVersion = "undefined";
    private String author = "undefined";
    private String authoringTool = "undefined";
    private Date dateCreated = new Date(0);
    private Date dateModified = new Date(0);
    private String unitName = "undefined";
    private float unitScale = 1.0f;
    private String upAxis = "undefined";


    /**
     * File source
     */
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Collada schema version
     */
    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    /**
     * Author of the content
     */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Tool the content was created in
     */
    public String getAuthoringTool() {
        return authoringTool;
    }

    public void setAuthoringTool(String authoringTool) {
        this.authoringTool = authoringTool;
    }

    /**
     * The date the collda file was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * The date the collada file was modified
     */
    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * The name of the unit
     */
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * The scale of one unit
     */
    public float getUnitScale() {
        return unitScale;
    }

    public void setUnitScale(float unitScale) {
        this.unitScale = unitScale;
    }

    /**
     * The name and direction of the upward axis
     */
    public String getUpAxis() {
        return upAxis;
    }

    public void setUpAxis(String upAxis) {
        this.upAxis = upAxis;
    }

    @Override
    public String toString() {
        return "ColladaHeader{" +
                "filename='" + filename + '\'' +
                ", schemaVersion='" + schemaVersion + '\'' +
                ", author='" + author + '\'' +
                ", authoringTool='" + authoringTool + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", unitName='" + unitName + '\'' +
                ", unitScale=" + unitScale +
                ", upAxis='" + upAxis + '\'' +
                '}';
    }
}
