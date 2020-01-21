package spring004web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import spring004web.entity.Prof;

@Repository
public class ListeProfDao implements IListeProfDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Prof> rechercheProfs() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Prof> lCriteriaQuery = lCriteriaBuilder.createQuery(Prof.class);
		final Root<Prof> lRoot = lCriteriaQuery.from(Prof.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Prof> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypedQuery.getResultList();
	}

	public void creerProf(Prof pProf) {
		// TODO Auto-generated method stub
		entityManager.persist(pProf);

	}

	public void supprimerProf(Prof pProf) {
		// TODO Auto-generated method stub
		final Prof lProf = entityManager.getReference(Prof.class, pProf.getId());
		entityManager.remove(lProf);

	}

	public void modifierProf(Prof pProf) {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaUpdate<Prof> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Prof.class);
		final Root<Prof> lRoot = lCriteriaUpdate.from(Prof.class);
		final Path<Prof> lPath = lRoot.get("id");
		final Expression<Boolean> lExpression = lCriteriaBuilder.equal(lPath, pProf.getId());
		lCriteriaUpdate.where(lExpression);
		lCriteriaUpdate.set("nom", pProf.getNom());
		final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
		final int lRowCount = lQuery.executeUpdate();
		if (lRowCount != 1) {
			final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
			final String lSql = lHQuery.getQueryString();
			throw new RuntimeException("Nombre d'occurences (" + lRowCount + ") modifiés différent de 1 pour " + lSql);
		}
	}


}
