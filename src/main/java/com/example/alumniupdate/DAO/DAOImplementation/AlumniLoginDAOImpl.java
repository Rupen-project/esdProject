package com.example.alumniupdate.DAO.DAOImplementation;

import com.example.alumniupdate.DAO.AlumniLoginDAO;
import com.example.alumniupdate.Util.HibernateSessionUtil;
import com.example.alumniupdate.bean.Alumni;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniLoginDAOImpl implements AlumniLoginDAO {

    @Override
    public void updateAlumni(Alumni a) {
        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(a);
            transaction.commit();
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            session.close();
        }
    }

    @Override
    public Alumni verify(Alumni alumni) {
        try (Session session = HibernateSessionUtil.getSession();){

            String sql = "FROM Alumni a where a.email = :alumniEmail and a.password = :alumniPassword";
            Query query = session.createQuery(sql);
            query.setParameter("alumniEmail", alumni.getEmail());
            query.setParameter("alumniPassword", alumni.getPassword());
            List res = query.list();
            if(res.size()==1){
                Alumni a = (Alumni) res.get(0);
                return a;
            }
            else{
                return null;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
