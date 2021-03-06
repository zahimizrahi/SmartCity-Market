package CartContracts;

import SMExceptions.SMException;

/**
 * This class define all the Exceptions {@link ACart} could throw.
 * 
 * @author Lior Ben Ami
 * @since 2017-01-04
 */
public class ACartExceptions extends SMException {

	private static final long serialVersionUID = -7538312012360295744L;

	/**
	 * Thrown when invalid (unsupported) command was sent by worker.
	 */
	public static class InvalidCommandDescriptor extends ACartExceptions {
		private static final long serialVersionUID = 5925504076668539623L;
	}
	
	/**
	 * Thrown when one of the parameters is illegal.
	 */
	public static class InvalidParameter extends ACartExceptions {
		private static final long serialVersionUID = -7605966916151865742L;
	}
	
	/**
	 * Thrown when unexpected error occurred
	 */
	public static class CriticalError extends ACartExceptions {
		private static final long serialVersionUID = -1013582717042687901L;
	}
	
	/**
	 * Thrown when try to login with wrong user id or password.
	 */
	public static class AuthenticationError extends ACartExceptions {
		private static final long serialVersionUID = -7277405499939708291L;
	}
	
	/**
	 * Thrown when cart try to do operation before connecting
	 */
	public static class CartNotConnected extends ACartExceptions {
		private static final long serialVersionUID = 4708231565561825649L;
	}

	/**
	 * Thrown when try to remove product that isn't in the cart.
	 */
	public static class ProductNotInCart extends ACartExceptions {
		private static final long serialVersionUID = -2078563581704067033L;
	}

	/**
	 * Thrown when requesting amount bigger than available.
	 */
	public static class AmountBiggerThanAvailable extends ACartExceptions {

		private static final long serialVersionUID = 1912331911777395334L;
	}
	
	/**
	 * Thrown when product package does not exist.
	 */
	public static class ProductPackageDoesNotExist extends ACartExceptions {
		private static final long serialVersionUID = -6889959552098680402L;
	}
	
	/**
	 * Thrown when try to checkout empty grocery list.
	 */
	public static class GroceryListIsEmpty extends ACartExceptions {
		private static final long serialVersionUID = 977822169247328736L;
	}
	
	/**
	 * Thrown when try to view product catalog which not exist.
	 */
	public static class ProductCatalogDoesNotExist extends ACartExceptions {
		private static final long serialVersionUID = 4795491771324789368L;
	}
}
