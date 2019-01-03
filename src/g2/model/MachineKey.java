package g2.model;

public class MachineKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Machine.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Machine.did
     *
     * @mbg.generated
     */
    private String did;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Machine
     *
     * @mbg.generated
     */
    public MachineKey(String id, String did) {
        this.id = id;
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Machine
     *
     * @mbg.generated
     */
    public MachineKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Machine.id
     *
     * @return the value of Machine.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Machine.id
     *
     * @param id the value for Machine.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Machine.did
     *
     * @return the value of Machine.did
     *
     * @mbg.generated
     */
    public String getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Machine.did
     *
     * @param did the value for Machine.did
     *
     * @mbg.generated
     */
    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }
}