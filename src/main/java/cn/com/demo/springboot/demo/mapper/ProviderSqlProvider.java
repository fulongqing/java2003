package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.entity.Provider;
import cn.com.demo.springboot.demo.entity.ProviderExample.Criteria;
import cn.com.demo.springboot.demo.entity.ProviderExample.Criterion;
import cn.com.demo.springboot.demo.entity.ProviderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProviderSqlProvider {

    public String countByExample(ProviderExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("smbms_provider");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProviderExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("smbms_provider");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Provider record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("smbms_provider");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProcode() != null) {
            sql.VALUES("proCode", "#{procode,jdbcType=VARCHAR}");
        }
        
        if (record.getProname() != null) {
            sql.VALUES("proName", "#{proname,jdbcType=VARCHAR}");
        }
        
        if (record.getProdesc() != null) {
            sql.VALUES("proDesc", "#{prodesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProcontact() != null) {
            sql.VALUES("proContact", "#{procontact,jdbcType=VARCHAR}");
        }
        
        if (record.getProphone() != null) {
            sql.VALUES("proPhone", "#{prophone,jdbcType=VARCHAR}");
        }
        
        if (record.getProaddress() != null) {
            sql.VALUES("proAddress", "#{proaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getProfax() != null) {
            sql.VALUES("proFax", "#{profax,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedby() != null) {
            sql.VALUES("createdBy", "#{createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.VALUES("creationDate", "#{creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifydate() != null) {
            sql.VALUES("modifyDate", "#{modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.VALUES("modifyBy", "#{modifyby,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProviderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("proCode");
        sql.SELECT("proName");
        sql.SELECT("proDesc");
        sql.SELECT("proContact");
        sql.SELECT("proPhone");
        sql.SELECT("proAddress");
        sql.SELECT("proFax");
        sql.SELECT("createdBy");
        sql.SELECT("creationDate");
        sql.SELECT("modifyDate");
        sql.SELECT("modifyBy");
        sql.FROM("smbms_provider");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Provider record = (Provider) parameter.get("record");
        ProviderExample example = (ProviderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("smbms_provider");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProcode() != null) {
            sql.SET("proCode = #{record.procode,jdbcType=VARCHAR}");
        }
        
        if (record.getProname() != null) {
            sql.SET("proName = #{record.proname,jdbcType=VARCHAR}");
        }
        
        if (record.getProdesc() != null) {
            sql.SET("proDesc = #{record.prodesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProcontact() != null) {
            sql.SET("proContact = #{record.procontact,jdbcType=VARCHAR}");
        }
        
        if (record.getProphone() != null) {
            sql.SET("proPhone = #{record.prophone,jdbcType=VARCHAR}");
        }
        
        if (record.getProaddress() != null) {
            sql.SET("proAddress = #{record.proaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getProfax() != null) {
            sql.SET("proFax = #{record.profax,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedby() != null) {
            sql.SET("createdBy = #{record.createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.SET("creationDate = #{record.creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifydate() != null) {
            sql.SET("modifyDate = #{record.modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.SET("modifyBy = #{record.modifyby,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("smbms_provider");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("proCode = #{record.procode,jdbcType=VARCHAR}");
        sql.SET("proName = #{record.proname,jdbcType=VARCHAR}");
        sql.SET("proDesc = #{record.prodesc,jdbcType=VARCHAR}");
        sql.SET("proContact = #{record.procontact,jdbcType=VARCHAR}");
        sql.SET("proPhone = #{record.prophone,jdbcType=VARCHAR}");
        sql.SET("proAddress = #{record.proaddress,jdbcType=VARCHAR}");
        sql.SET("proFax = #{record.profax,jdbcType=VARCHAR}");
        sql.SET("createdBy = #{record.createdby,jdbcType=BIGINT}");
        sql.SET("creationDate = #{record.creationdate,jdbcType=TIMESTAMP}");
        sql.SET("modifyDate = #{record.modifydate,jdbcType=TIMESTAMP}");
        sql.SET("modifyBy = #{record.modifyby,jdbcType=BIGINT}");
        
        ProviderExample example = (ProviderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Provider record) {
        SQL sql = new SQL();
        sql.UPDATE("smbms_provider");
        
        if (record.getProcode() != null) {
            sql.SET("proCode = #{procode,jdbcType=VARCHAR}");
        }
        
        if (record.getProname() != null) {
            sql.SET("proName = #{proname,jdbcType=VARCHAR}");
        }
        
        if (record.getProdesc() != null) {
            sql.SET("proDesc = #{prodesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProcontact() != null) {
            sql.SET("proContact = #{procontact,jdbcType=VARCHAR}");
        }
        
        if (record.getProphone() != null) {
            sql.SET("proPhone = #{prophone,jdbcType=VARCHAR}");
        }
        
        if (record.getProaddress() != null) {
            sql.SET("proAddress = #{proaddress,jdbcType=VARCHAR}");
        }
        
        if (record.getProfax() != null) {
            sql.SET("proFax = #{profax,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedby() != null) {
            sql.SET("createdBy = #{createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.SET("creationDate = #{creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifydate() != null) {
            sql.SET("modifyDate = #{modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.SET("modifyBy = #{modifyby,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProviderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}