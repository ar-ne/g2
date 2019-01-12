package g2.mapper;

import g2.mapper.Extra.ScheduleExt;
import g2.model.Schedule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScheduleMapper extends ScheduleExt {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    @Delete({
        "delete from schedule",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    @Insert({
            "insert into schedule (id, start, ",
            "stop, address)",
            "values (#{id,jdbcType=NUMERIC}, #{start,jdbcType=TIMESTAMP}, ",
            "#{stop,jdbcType=TIMESTAMP}, #{address,jdbcType=VARCHAR})"
    })
    int insert(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    int insertSelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    @Select({
        "select",
            "id, start, stop, address",
        "from schedule",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    @ResultMap("g2.mapper.ScheduleMapper.BaseResultMap")
    Schedule selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Schedule record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule
     *
     * @mbg.generated
     */
    @Update({
        "update schedule",
            "set start = #{start,jdbcType=TIMESTAMP},",
            "stop = #{stop,jdbcType=TIMESTAMP},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int updateByPrimaryKey(Schedule record);
}