package CartContracts;

import java.util.HashMap;

import BasicCommonClasses.CartProduct;
import BasicCommonClasses.CatalogProduct;
import BasicCommonClasses.SmartCode;
import CartContracts.ACartExceptions.AmountBiggerThanAvailable;
import CartContracts.ACartExceptions.AuthenticationError;
import CartContracts.ACartExceptions.CartNotConnected;
import CartContracts.ACartExceptions.CriticalError;
import CartContracts.ACartExceptions.GroceryListIsEmpty;
import CartContracts.ACartExceptions.ProductCatalogDoesNotExist;
import CartContracts.ACartExceptions.ProductNotInCart;
import CartContracts.ACartExceptions.ProductPackageDoesNotExist;

/**
 * ICart - This interface is the contract for Cart Type.
 *
 * @author Lior Ben Ami
 * @since 2017-01-04
 */
public interface ICart {
	/**
	 * getId - returns the cart's id
	 * @return int
	 */
	int getId();

	/**
	 * getCartProductCache - returns the current CartProduct Cache.
	 * @return HashMap<SmartCode, CartProduct> 
	 */
	HashMap<Long, CartProduct> getCartProductCache();
	
	/**
	 * login - the cart login to the server and gets it's own id;
	 * @throws CriticalError 
	 * @throws AuthenticationError
	 */
	void login(String username, String password) throws CriticalError, AuthenticationError;
	
	/**
	 * logout - the cart logout from  the server. To use in the end of the shopping.
	 * @throws CartNotConnected 
	 * @throws CriticalError 
	 */
	void logout() throws CartNotConnected, CriticalError;
	
	/**
	 * resume - saves the data of the cart from the server (to use in case of collapse)
	 * @param int _id
	 * @throws CriticalError 
	 * @throws CartNotConnected 
	 * @throws ProductCatalogDoesNotExist 
	 */
	void resume(int _id) throws CriticalError, CartNotConnected, ProductCatalogDoesNotExist;
	
	/**
	 * addPtoductToCart - Adds product with amount to the cart
	 * 
	 * @param SmartCode c
	 * @param int amount
	 * @throws CriticalError 
	 * @throws CartNotConnected 
	 * @throws ProductPackageDoesNotExist 
	 * @throws AmountBiggerThanAvailable 
	 * @throws ProductCatalogDoesNotExist 
	 */
	void addProductToCart(SmartCode c, int amount) throws CriticalError, CartNotConnected, AmountBiggerThanAvailable, ProductPackageDoesNotExist, ProductCatalogDoesNotExist;
	
	/**
	 * returnProductToShelf - removes product with amount from the cart
	 * 
	 * @param SmartCode c 
	 * @param  int amount
	 * @throws ProductNotInCart
	 * @throws AmountBiggerThanAvailable 
	 * @throws CriticalError 
	 * @throws CartNotConnected 
	 * @throws ProductPackageDoesNotExist 
	 */
	void returnProductToShelf(SmartCode c, int amount) throws CriticalError, CartNotConnected, ProductNotInCart, AmountBiggerThanAvailable, ProductPackageDoesNotExist;
	
	/**
	 * getTotalSum - returns the total sum of the shopping
	 * @return Double
	 */
	Double getTotalSum(); 
	
	/**
	 * getCartProductsNum - returns the number of the CarProducts in the cart
	 * @return Integer
	 */
	Integer getCartProductsNum();
	
	/**
	 * checkOutGroceryList - returns the finale total sum of the shopping and initialize grocery list
	 * @return Double
	 * @throws CriticalError 
	 * @throws CartNotConnected 
	 * @throws GroceryListIsEmpty 
	 */
	Double checkOutGroceryList() throws CriticalError, CartNotConnected, GroceryListIsEmpty;

	CartProduct getCartProduct(SmartCode c);

	/**
	 * @throws CriticalError 
	 * @throws CartNotConnected 
	 * @throws ProductCatalogDoesNotExist
	 */
	CatalogProduct viewCatalogProduct(SmartCode c) throws CriticalError, CartNotConnected, ProductCatalogDoesNotExist;
	
	/**
	 * @throws ProductNotInCart 
	 * @throws CriticalError 
	 * 
	 */
	void removeAllItemsOfCartProduct(SmartCode c) throws ProductNotInCart, CriticalError;
}