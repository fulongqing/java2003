package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.entity.Bill;
import cn.com.demo.springboot.demo.entity.BillExample.Criteria;
import cn.com.demo.springboot.demo.entity.BillExample.Criterion;
import cn.com.demo.springboot.demo.entity.BillExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class BillSqlProvider {

    public String countByExample(BillExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("smbms_bill");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BillExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("smbms_bill");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Bill record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("smbms_bill");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getBillcode() != null) {
            sql.VALUES("billCode", "#{billcode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductname() != null) {
            sql.VALUES("productName", "#{productname,jdbcType=VARCHAR}");
        }
        
        if (record.getProductdesc() != null) {
            sql.VALUES("productDesc", "#{productdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProductunit() != null) {
            sql.VALUES("productUnit", "#{productunit,jdbcType=VARCHAR}");
        }
        
        if (record.getProductcount() != null) {
            sql.VALUES("productCount", "#{productcount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.VALUES("totalPrice", "#{totalprice,jdbcType=DECIMAL}");
        }
        
        if (record.getIspayment() != null) {
            sql.VALUES("isPayment", "#{ispayment,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedby() != null) {
            sql.VALUES("createdBy", "#{createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.VALUES("creationDate", "#{creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.VALUES("modifyBy", "#{modifyby,jdbcType=BIGINT}");
        }
        
        if (record.getModifydate() != null) {
            sql.VALUES("modifyDate", "#{modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProviderid() != null) {
            sql.VALUES("providerId", "#{providerid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BillExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("billCode");
        sql.SELECT("productName");
        sql.SELECT("productDesc");
        sql.SELECT("productUnit");
        sql.SELECT("productCount");
        sql.SELECT("totalPrice");
        sql.SELECT("isPayment");
        sql.SELECT("createdBy");
        sql.SELECT("creationDate");
        sql.SELECT("modifyBy");
        sql.SELECT("modifyDate");
        sql.SELECT("providerId");
        sql.FROM("smbms_bill");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Bill record = (Bill) parameter.get("record");
        BillExample example = (BillExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("smbms_bill");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBillcode() != null) {
            sql.SET("billCode = #{record.billcode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductname() != null) {
            sql.SET("productName = #{record.productname,jdbcType=VARCHAR}");
        }
        
        if (record.getProductdesc() != null) {
            sql.SET("productDesc = #{record.productdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProductunit() != null) {
            sql.SET("productUnit = #{record.productunit,jdbcType=VARCHAR}");
        }
        
        if (record.getProductcount() != null) {
            sql.SET("productCount = #{record.productcount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.SET("totalPrice = #{record.totalprice,jdbcType=DECIMAL}");
        }
        
        if (record.getIspayment() != null) {
            sql.SET("isPayment = #{record.ispayment,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedby() != null) {
            sql.SET("createdBy = #{record.createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.SET("creationDate = #{record.creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.SET("modifyBy = #{record.modifyby,jdbcType=BIGINT}");
        }
        
        if (record.getModifydate() != null) {
            sql.SET("modifyDate = #{record.modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProviderid() != null) {
            sql.SET("providerId = #{record.providerid,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("smbms_bill");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("billCode = #{record.billcode,jdbcType=VARCHAR}");
        sql.SET("productName = #{record.productname,jdbcType=VARCHAR}");
        sql.SET("productDesc = #{record.productdesc,jdbcType=VARCHAR}");
        sql.SET("productUnit = #{record.productunit,jdbcType=VARCHAR}");
        sql.SET("productCount = #{record.productcount,jdbcType=DECIMAL}");
        sql.SET("totalPrice = #{record.totalprice,jdbcType=DECIMAL}");
        sql.SET("isPayment = #{record.ispayment,jdbcType=INTEGER}");
        sql.SET("createdBy = #{record.createdby,jdbcType=BIGINT}");
        sql.SET("creationDate = #{record.creationdate,jdbcType=TIMESTAMP}");
        sql.SET("modifyBy = #{record.modifyby,jdbcType=BIGINT}");
        sql.SET("modifyDate = #{record.modifydate,jdbcType=TIMESTAMP}");
        sql.SET("providerId = #{record.providerid,jdbcType=INTEGER}");
        
        BillExample example = (BillExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Bill record) {
        SQL sql = new SQL();
        sql.UPDATE("smbms_bill");
        
        if (record.getBillcode() != null) {
            sql.SET("billCode = #{billcode,jdbcType=VARCHAR}");
        }
        
        if (record.getProductname() != null) {
            sql.SET("productName = #{productname,jdbcType=VARCHAR}");
        }
        
        if (record.getProductdesc() != null) {
            sql.SET("productDesc = #{productdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getProductunit() != null) {
            sql.SET("productUnit = #{productunit,jdbcType=VARCHAR}");
        }
        
        if (record.getProductcount() != null) {
            sql.SET("productCount = #{productcount,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalprice() != null) {
            sql.SET("totalPrice = #{totalprice,jdbcType=DECIMAL}");
        }
        
        if (record.getIspayment() != null) {
            sql.SET("isPayment = #{ispayment,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedby() != null) {
            sql.SET("createdBy = #{createdby,jdbcType=BIGINT}");
        }
        
        if (record.getCreationdate() != null) {
            sql.SET("creationDate = #{creationdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyby() != null) {
            sql.SET("modifyBy = #{modifyby,jdbcType=BIGINT}");
        }
        
        if (record.getModifydate() != null) {
            sql.SET("modifyDate = #{modifydate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProviderid() != null) {
            sql.SET("providerId = #{providerid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BillExample example, boolean includeExamplePhrase) {
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