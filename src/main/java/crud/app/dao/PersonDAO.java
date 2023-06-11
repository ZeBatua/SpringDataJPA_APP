package crud.app.dao;

import crud.app.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@EnableTransactionManagement

public class PersonDAO {

    private final SessionFactory sessionFactory;
    private int batchUseCounter;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        session.createNativeQuery("TRUNCATE TABLE Person");
    }

    @Transactional
    public void testMultipleUpdate() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();
        for (Person person : people) session.persist(person);
        long after = System.currentTimeMillis();

        System.out.println("Time: " + (after - before));
    }

    @Transactional
    public void testBatchUpdate() {
//        List<Person> people = create1000People();
//        Session session = sessionFactory.getCurrentSession();
//        session.setJdbcBatchSize(1000);
//
//        long before = System.currentTimeMillis();
//        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?, ?, ?, ?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setInt(1, people.get(i).getId());
//                        ps.setString(2, people.get(i).getName());
//                        ps.setInt(3, people.get(i).getAge());
//                        ps.setString(4, people.get(i).getEmail());
//                    }
//                    @Override
//                    public int getBatchSize() {
//                        return people.size();
//                    }
//                });
//
//        long after = System.currentTimeMillis();
//        System.out.println("Time: " + (after - before));
    }

    private List<Person> create1000People() {
        List<Person> people = new ArrayList<>();
        int amount = 10; // 1000 default
        for (int i = (batchUseCounter == 0 ? 0 : batchUseCounter * amount);  i < amount * (batchUseCounter + 1); i++) {
            people.add(new Person("test" + i, i + 18, "test" + i + "@mail.test"));
        }
        batchUseCounter++;
        return people;
    }
}
