package org.opennms.netmgt.provision.persist.policies;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.netmgt.dao.DatabasePopulator;
import org.opennms.netmgt.dao.SnmpInterfaceDao;
import org.opennms.netmgt.dao.db.JUnitTemporaryDatabase;
import org.opennms.netmgt.dao.db.OpenNMSConfigurationExecutionListener;
import org.opennms.netmgt.dao.db.TemporaryDatabaseExecutionListener;
import org.opennms.netmgt.model.OnmsSnmpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
    OpenNMSConfigurationExecutionListener.class,
    TemporaryDatabaseExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class
})
@ContextConfiguration(locations={
        "classpath:/META-INF/opennms/applicationContext-dao.xml",
        "classpath:/META-INF/opennms/applicationContext-databasePopulator.xml"
})

@JUnitTemporaryDatabase()
public class CollectionPolicyTest {
    @Autowired
    private SnmpInterfaceDao m_snmpInterfaceDao;

    @Autowired
    private DatabasePopulator m_populator;

    private List<OnmsSnmpInterface> m_interfaces;
    
    @Before
    public void setUp() {
        m_populator.populateDatabase();
        m_interfaces = m_snmpInterfaceDao.findAll();
    }
    
    @Test
    @Transactional
    public void testMatchingIfDescr() {
        MatchingSnmpInterfacePolicy p = new MatchingSnmpInterfacePolicy();
        p.setIfDescr("~^ATM.*");

        matchPolicy(p, "192.168.1.1");
    }

    @Test
    @Transactional
    public void testMatchingIfName() {
        MatchingSnmpInterfacePolicy p = new MatchingSnmpInterfacePolicy();
        p.setIfName("eth0");

        matchPolicy(p, "192.168.1.2");
    }

    @Test
    @Transactional
    public void testMatchingIfType() {
        MatchingSnmpInterfacePolicy p = new MatchingSnmpInterfacePolicy();
        p.setIfType("6");

        matchPolicy(p, "192.168.1.2");
    }

    private void matchPolicy(MatchingSnmpInterfacePolicy p, String matchingIp) {
        OnmsSnmpInterface o;
        List<OnmsSnmpInterface> populatedInterfaces = new ArrayList<OnmsSnmpInterface>();
        List<OnmsSnmpInterface> matchedInterfaces = new ArrayList<OnmsSnmpInterface>();
        
        for (OnmsSnmpInterface iface : m_interfaces) {
            System.err.println(iface);
            o = p.apply(iface);
            if (o != null) {
                matchedInterfaces.add(o);
            }
            if (iface.getIpAddress().equalsIgnoreCase(matchingIp)) {
                populatedInterfaces.add(iface);
            }
        }
        
        assertEquals(populatedInterfaces, matchedInterfaces);
    }

}
