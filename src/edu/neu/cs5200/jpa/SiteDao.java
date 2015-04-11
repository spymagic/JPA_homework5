package edu.neu.cs5200.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api")
public class SiteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = factory.createEntityManager();	

	@GET
	@Path("/site")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Site> findAllSites(){
		List<Site> site = new ArrayList<Site>();
		Query query = em.createQuery("select site from Site site");
		query.getResultList();
		return site;	
	}
	
	
	@GET
	@Path("/site/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId){
		Site site = null;
		site = em.find(Site.class, siteId);
		return site;
		
	}

	@POST
	@Path("/site")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site){
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		
		List<Site> sites = new ArrayList<Site>();
		Query query = em.createQuery("select site from Site site");
		query.getResultList();
		return sites;
	}


	@PUT
	@Path("/site/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site){
		em.getTransaction().begin();
		site.setId(siteId);
		em.merge(site);
		em.getTransaction().commit();

		List<Site> sites = new ArrayList<Site>();
		Query query = em.createQuery("select site from Site site");
		query.getResultList();
		return sites;
		
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Site> removeSite(@PathParam("id") int siteId){
		em.getTransaction().begin();
		Site site = null;
		site = em.find(Site.class, siteId);
		em.remove(site);
		em.getTransaction().commit();
		
		List<Site> sites = new ArrayList<Site>();
		Query query = em.createQuery("select site from Site site");
		query.getResultList();
		return sites;
	}



	
}
