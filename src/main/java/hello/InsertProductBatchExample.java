package hello;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertProductBatchExample {
    public static void main(String[] args)
    {
        Session session = null;
        Transaction transaction = null;
        // Setting zero or negative number will disable the
        // batching.
        int batchSize
                = 10; // As of now, it is hardcoded to 10
        try {
            session = HibernateUtil.getSessionFactory()
                    .openSession();
            transaction = session.beginTransaction();
            // Here as a sample 100 items are inserted, but
            // it can be changed as per user choice
            for (long idx = 1; idx <= 100; idx++) {
                Product product = new Product();
                // We can use this as sample. Please change
                // according to the requirement
                product.setProductName("Product" + idx);
                product.setProductBrand("A");
                product.setPrice((int)idx * 10);
                session.save(product);
                if (idx > 0
                        && idx % batchSize
                        == 0) { // Keep on doing this
                    // step in order to
                    // continue and avoid
                    // exceptions
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }

        HibernateUtil.shutdown();
    }
}

