package com.example.alumniupdate.DAO.DAOImplementation;

import com.example.alumniupdate.DAO.AlumniDAO;
import com.example.alumniupdate.Util.HibernateSessionUtil;
import com.example.alumniupdate.bean.Alumni;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniDAOImpl implements AlumniDAO {

    @Override
    public Alumni getAlumniById(int alumniId) {
        try (Session session = HibernateSessionUtil.getSession();){

            String sql = "FROM Alumni a where a.alumniId = :alumniId";
            Query query = session.createQuery(sql);
            query.setParameter("alumniId", alumniId);
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
