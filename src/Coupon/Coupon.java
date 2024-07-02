package Coupon;

	import java.util.concurrent.Delayed;
	import java.util.concurrent.TimeUnit;

	public class Coupon implements Delayed {
	    private String couponCode;
	    private long expirationTime;

	    public Coupon(String couponCode, long delayMs) {
	        this.couponCode = couponCode;
	        this.expirationTime = System.currentTimeMillis() + delayMs;
	    }

	    public String getCouponCode() {
	        return couponCode;
	    }

	    @Override
	    public long getDelay(TimeUnit unit) {
	        long delay = expirationTime - System.currentTimeMillis();
	        return unit.convert(delay, TimeUnit.MILLISECONDS);
	    }

	    @Override
	    public int compareTo(Delayed other) {
	        if (this.expirationTime < ((Coupon) other).expirationTime) {
	            return -1;
	        }
	        if (this.expirationTime > ((Coupon) other).expirationTime) {
	            return 1;
	        }
	        return 0;
	    }
	}


