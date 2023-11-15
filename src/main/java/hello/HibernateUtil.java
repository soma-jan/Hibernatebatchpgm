package hello;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;
    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder
                        registryBuilder
                        = new StandardServiceRegistryBuilder();

                // Configuration properties
                Map<String, Object> settings
                        = new HashMap<>();

                settings.put(Environment.DRIVER,
                        "org.postgresql.Driver");

                settings.put(
                        Environment.URL,
                        "jdbc:postgresql://localhost:5432/postgres");
                // Specify mySQL credentials here
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "admin");

                settings.put(Environment.HBM2DDL_AUTO,
                        "update");
                // Set JDBC batch size. It can be set
                // between 10 and 50
                settings.put(
                        Environment.STATEMENT_BATCH_SIZE, 50);

                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();

                MetadataSources sources
                        = new MetadataSources(registry);

                // This entity class Product is going to be
                // used for batch insert or update
                sources.addAnnotatedClass(Product.class);
                Metadata metadata
                        = sources.getMetadataBuilder().build();

                sessionFactory
                        = metadata.getSessionFactoryBuilder()
                        .build();
            }
            catch (Exception e) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(
                            registry);
                }
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void shutdown()
    {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(
                    registry);
        }
    }
}