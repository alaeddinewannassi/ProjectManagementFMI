package com.adp.business.dao;

import java.util.List;

import com.adp.entities.AbstractEntity;
import com.adp.exceptions.ADPException;

public interface GenericDAO<E extends AbstractEntity> {

	/**
	 * Mettre a jour un objet DTO.
	 * 
	 * @param sourceDTO
	 *            DTO à enregistrer
	 * @return l'objet après enregistrement
	 * @throws ADPException
	 *             PocGBException
	 */
	E merge(E sourceDTO) throws ADPException;

	/**
	 * Enregistrer un objet DTO.
	 * 
	 * @param entity
	 *            Entite à enregistrer
	 * @return l'objet après enregistrement
	 * @throws MCMBMCMBException
	 *             PocGBMCMBException
	 */
	E persist(E entity) throws ADPException;

	/**
	 * Chercher un objet ETO par son IE.
	 * 
	 * @param entityId
	 *            IE
	 * @return Objet recherché.
	 * @throws ADPException
	 *             MCMBException
	 */
	E load(Long entityId) throws ADPException;

	/**
	 * Chercher un objet ETO par son IE.
	 * 
	 * @param entityId
	 *            IE
	 * @return Objet recherché.
	 * @throws ADPException
	 *             MCMBException
	 */
	E loadNoSession(Long entityId) throws ADPException;

	/**
	 * Supprimer une entité
	 * 
	 * @param entity
	 *            Entité
	 * @throws ADPException
	 *             MCMBException
	 */
	void remove(E entity) throws ADPException;

	/**
	 * Charger l'entité avec l'id en paramètre puis la supprimer afin
	 * d'éviter l'exception "detached object".
	 * 
	 * @param entityId
	 *            Id entité à supprimer
	 * @throws ADPException
	 *             MCMBException
	 */
	void remove(Long entityId) throws ADPException;

	/**
	 * Chercher toutes les entités.
	 * 
	 * @return Liste des objets recherchés
	 * @throws ADPException
	 *             MCMBException
	 */
	List<E> findAll() throws ADPException;

	/**
	 * Chercher une liste d'objets selon des critères.
	 * 
	 * @param criteria
	 *            Requête specifique
	 * @return Résultat sous forme d'une liste
	 * @throws ADPException
	 *             MCMBException
	 */
	List<E> findByCriteria(String criteria) throws ADPException;

}
