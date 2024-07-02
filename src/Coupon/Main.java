package Coupon;

public class Main {

	public static void main(String[] args) {
		// Create a CouponManager instance
		CouponManager manager = new CouponManager();

		// Add coupons with different expiration delays
		manager.addCoupon(new Coupon("50EUXNVH", 5000)); // Expires in 5 seconds
		manager.addCoupon(new Coupon("10DURAWIPES", 10000)); // Expires in 10 seconds
		manager.addCoupon(new Coupon("30CY8XAU", 15000)); // Expires in 15 seconds

		// Start processing expired coupons
		manager.startProcessing();

		// Main thread sleeps for demonstration purposes
		try {
			Thread.sleep(20000); // Sleep for 20 seconds to allow processing of all coupons
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

