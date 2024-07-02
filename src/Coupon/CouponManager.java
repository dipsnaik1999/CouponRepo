package Coupon;

	import java.util.concurrent.DelayQueue;
	import java.util.concurrent.TimeUnit;

	public class CouponManager {
	    private DelayQueue<Coupon> delayQueue = new DelayQueue<>();

	    public void addCoupon(Coupon coupon) {
	        delayQueue.put(coupon);
	        System.out.println("Coupon added: " + coupon.getCouponCode());
	    }

	    public void startCouponExpiryListener() {
	        Thread expiryListener = new Thread(() -> {
	            while (true) {
	                try {
	                    Coupon expiredCoupon = delayQueue.take();
	                    System.out.println("Expired coupon: " + expiredCoupon.getCouponCode());
	                    
	                    // Perform any additional processing for expired coupon here
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	        expiryListener.start();
	    }

	    public static void main(String[] args) {
	        CouponManager couponManager = new CouponManager();

	        // Start the coupon expiry listener thread
	        couponManager.startCouponExpiryListener();

	        // Add some test coupons with expiration delays
	        couponManager.addCoupon(new Coupon("Amazon", TimeUnit.SECONDS.toMillis(10))); // expires in 10 seconds
	        couponManager.addCoupon(new Coupon("FlipKart", TimeUnit.SECONDS.toMillis(5)));  // expires in 5 seconds

	        // Let the thread keep running to process expirations
	        try {
	            Thread.sleep(TimeUnit.SECONDS.toMillis(15)); // sleep for 15 seconds to allow all coupons to expire
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

		public void startProcessing() {
			// TODO Auto-generated method stub
			
		}
	}

