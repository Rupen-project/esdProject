package com.example.alumniupdate.DAO.DAOImplementation;

import com.example.alumniupdate.DAO.AlumniDAO;
import com.example.alumniupdate.Util.HibernateSessionUtil;
import com.example.alumniupdate.bean.Alumni;
import com.example.alumniupdate.bean.Alumni_Organisation;
import com.example.alumniupdate.bean.Alumni_education;
import com.example.alumniupdate.bean.Organisation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    @Override
    public Alumni_education getAlumniEducationById(int alumniId) {
        try (Session session = HibernateSessionUtil.getSession();){

            String sql = "FROM Alumni_education a where a.alumni.alumniId = :alumniId";
            Query query = session.createQuery(sql);
            query.setParameter("alumniId", alumniId);
            List res = query.list();
            if(res.size()==1){
                Alumni_education a = (Alumni_education) res.get(0);
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

    @Override
    public List<Alumni_Organisation> getAlumniOrganisationById(int alumniId) {
        try (Session session = HibernateSessionUtil.getSession();){

            String sql = "FROM Alumni_Organisation a where a.alumni.alumniId = :alumniId";
            Query query = session.createQuery(sql);
            query.setParameter("alumniId", alumniId);
            List res = query.list();
            if(res.size()>0){
                List<Alumni_Organisation> a = new ArrayList<>();
                for(Object o : res){
                    a.add((Alumni_Organisation) o);
                }
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

    @Override
    public boolean updateAlumni(Alumni alumni) {

        Transaction tx = null;

        try (Session session = HibernateSessionUtil.getSession();){


//            String sql = "FROM Alumni a where a.alumniId = :alumniId";
//            Query query = session.createQuery(sql);
//            query.setParameter("alumniId", alumni.getAlumniId());
//            List res = query.list();
//            if(res.size()==0) return false;
//            Alumni a = (Alumni) res.get(0);
//            a.setContact_number(alumni.getContact_number());
//            a.setEmail(alumni.getEmail());
//            session.update(a);
//            session.getTransaction().commit();

            tx=session.getTransaction();
            tx.begin();
            String sql = "update Alumni a set a.email=:alumniEmail, a.contact_number=:alumniContact where a.alumniId = :alumniId";
            Query query = session.createQuery(sql);
            query.setParameter("alumniEmail", alumni.getEmail());
            query.setParameter("alumniContact", alumni.getContact_number());
            query.setParameter("alumniId", alumni.getAlumniId());

            if(query.executeUpdate() > 0){
                tx.commit();
                return true;
            }

                return false;


        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            tx.rollback();
            return false;
        }

    }

    @Override
    public boolean updateAlumniEducation(Alumni_education alumniEducation) {
        Transaction tx = null;
        try (Session session = HibernateSessionUtil.getSession();){
            tx=session.getTransaction();
            tx.begin();
            String sql = "update Alumni_education a set a.address=:alumniAddress, a.collegeName=:alumniCollegeName, " +
                    "a.degree=:alumniDegree,a.joining_year=:alumniJY,a.passing_year=:alumniPY where  a.alumni.alumniId = :alumniId";
            Query query = session.createQuery(sql);
            query.setParameter("alumniAddress", alumniEducation.getAddress());
            query.setParameter("alumniCollegeName", alumniEducation.getCollegeName());
            query.setParameter("alumniDegree", alumniEducation.getDegree());
            query.setParameter("alumniJY", alumniEducation.getJoining_year());
            query.setParameter("alumniPY", alumniEducation.getPassing_year());
            query.setParameter("alumniId", alumniEducation.getAlumni().getAlumniId());


            if(query.executeUpdate() > 0){
                tx.commit();
                return true;
            }

            return false;


        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            tx.rollback();
            return false;
        }
    }

    @Override
    public List<Organisation> getOrganisations() {
        try (Session session = HibernateSessionUtil.getSession();){

            String sql = "FROM Organisation ";
            Query query = session.createQuery(sql);
            List<Organisation> a = new ArrayList<>();
            for(Object o : query.list()){
                a.add((Organisation) o);
            }
            return a;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean deleteOrganisation(Alumni_Organisation alumni_organisation) {
        Transaction tx = null;
        try (Session session = HibernateSessionUtil.getSession();){
            tx=session.getTransaction();
            tx.begin();

            String sql = "delete from Alumni_Organisation a where a.alumniOrganisationId = :id ";
            Query query = session.createQuery(sql);
            query.setParameter("id", alumni_organisation.getAlumniOrganisationId());
            if(query.executeUpdate() > 0){
                tx.commit();
                return true;
            }

            return false;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean updateOrganisation(Alumni_Organisation alumni_organisation) {
        Transaction tx = null;
        try (Session session = HibernateSessionUtil.getSession();){
            tx=session.getTransaction();
            tx.begin();
            String sql = "update Alumni_Organisation a set a.joining_date=:JD, a.leaving_date=:LD, " +
                    "a.position=:P where  a.alumniOrganisationId = :id";
            Query query = session.createQuery(sql);
            query.setParameter("JD", alumni_organisation.getJoining_date());
            query.setParameter("LD", alumni_organisation.getLeaving_date());
            query.setParameter("P", alumni_organisation.getPosition());
            query.setParameter("id", alumni_organisation.getAlumniOrganisationId());


            if(query.executeUpdate() > 0){
                tx.commit();
                return true;
            }

            return false;


        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean addOrganisation(Alumni_Organisation alumni_organisation) {

        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(alumni_organisation);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch ( Exception e){
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }


}
