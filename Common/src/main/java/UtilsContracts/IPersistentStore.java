package UtilsContracts;


/** IPersistentStore - An interface that represents persistence.
 * @author Shimon Azulay
 * @since 2016-03-28 */

public interface IPersistentStore {

	/**
	 * @param requester
	 * @param objectToStore
	 * 
	 * @throws Exception
	 */
	void storeObject(Object requester, Object objectToStore) throws Exception;
	
	/**
	 * @param requester
	 * @param restoredType
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	<TObject> TObject restoreObject(Object requester, Class<TObject> restoredType) throws Exception;
}
