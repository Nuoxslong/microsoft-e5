package cn.codegraffiti.microsofte5.utils.id;



import cn.codegraffiti.microsofte5.utils.GenerateIdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SnowflakeId implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return GenerateIdUtil.nextId();
    }
}
