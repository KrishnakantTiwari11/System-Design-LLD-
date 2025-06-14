public class Location {
        private double x;
        private double y;
    
        public Location(double x, double y) {
            this.x = x;
            this.y = y;
        }
    
        // printing object of this class will call toString.
        @Override
        public String toString() {
            return ("(" + x + "," + y + ")");
        }
    
        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    
        public double getX() {
            return x;
        }
    
        public double getY() {
            return y;
        }
    
        public double getDistance(Location source) {
            double dx = this.x - source.x;
            double dy = this.y - source.y;
            double result = Math.sqrt(dx * dx + dy * dy);
            return result;
        }
    
    }
