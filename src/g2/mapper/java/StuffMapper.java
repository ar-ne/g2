package g2.mapper.java;

import g2.model.Stuff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StuffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    @Delete({
        "delete from stuff",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    @Insert({
        "insert into stuff (id, name, ",
        "sid, did)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sid,jdbcType=VARCHAR}, #{did,jdbcType=VARCHAR})"
    })
    int insert(Stuff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    int insertSelective(Stuff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, name, sid, did",
        "from stuff",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("g2.mapper.java.StuffMapper.BaseResultMap")
    Stuff selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Stuff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stuff
     *
     * @mbg.generated
     */
    @Update({
        "update stuff",
        "set name = #{name,jdbcType=VARCHAR},",
          "sid = #{sid,jdbcType=VARCHAR},",
          "did = #{did,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Stuff record);
}