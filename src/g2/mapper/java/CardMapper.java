package g2.mapper.java;

import g2.model.Card;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    @Delete({
        "delete from Card",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    @Insert({
        "insert into Card (id, state, ",
        "amount, limit)",
        "values (#{id,jdbcType=NUMERIC}, #{state,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DOUBLE}, #{limit,jdbcType=DOUBLE})"
    })
    int insert(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    int insertSelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, state, amount, limit",
        "from Card",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    @ResultMap("g2.mapper.java.CardMapper.BaseResultMap")
    Card selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Card record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Card
     *
     * @mbg.generated
     */
    @Update({
        "update Card",
        "set state = #{state,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DOUBLE},",
          "limit = #{limit,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int updateByPrimaryKey(Card record);
}