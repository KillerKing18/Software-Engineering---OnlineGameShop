package transfer;

import java.util.Date;

public class Item {

        private int id;
        private String title;
        private double price;
        private Date releaseDate;
        private String developer;
        private int numberOfCopies;
        private String imagePath;

        public long getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getTitle()
        {
                return title;
        }

        public void setTitle(String title)
        {
                this.title = title;
        }

        public double getPrice()
        {
                return price;
        }

        public void setPrice(double price)
        {
                this.price = price;
        }

        public Date getReleaseDate()
        {
                return releaseDate;
        }

        public void setReleaseDate(Date releaseDate)
        {
                this.releaseDate = releaseDate;
        }

        public String getDeveloper()
        {
                return developer;
        }

        public void setDeveloper(String developer)
        {
                this.developer = developer;
        }

        public int getNumberOfCopies()
        {
                return numberOfCopies;
        }

        public void setNumberOfCopies(int numberOfCopies)
        {
                this.numberOfCopies = numberOfCopies;
        }

		public String getImagePath() {
			return imagePath;
		}

		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}

        //public void displayInformation();
        //public boolean inStock(); //MUST BE IMPLEMENTED USING TRANSFER AND DAO

}
