public class Second {
    public static class MediaItem{
        String title;
        int duration;
        String media_type;

        public MediaItem(String title,int duration,String media_type)
        {
            this.title=title;
            this.duration=duration;
            this.media_type=media_type;
        }
        public void display_info(){
            System.out.println("Title: "+title);
            System.out.println("Duration: "+duration);
            System.out.println("Media type: "+media_type);
        }
    }

    public static class Book extends MediaItem {
        String Author;

        public Book(String title,int duration,String media_type,String Author)
        {
            super(title,duration,media_type);
            this.Author=Author;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Author: "+Author);
        }
    }
    public static class Movie extends MediaItem {
        String director;

        public Movie(String title,int duration,String media_type,String dir)
        {
            super(title,duration,media_type);
            this.director=dir;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Director: "+director);
        }
    }
    public static class MusicAlbum extends MediaItem {
        String Artist;

        public MusicAlbum(String title,int duration,String media_type,String Artist)
        {
            super(title,duration,media_type);
            this.Artist=Artist;
        }
        public void display_info()
        {
            super.display_info();
            System.out.println("Artist: "+Artist);
        }
    }


    public static void main(String[] args)
    {
        MediaItem o1=new MediaItem("3 Idiots",200,"Movie");
        o1.display_info();
        System.out.println("-------------------------");
        Book book1=new Book("Rich Dad Poor Dad",200,"Book","Robert T. Kiyosaki and Sharon Lechter");
        book1.display_info();
        System.out.println("-------------------------");

        Movie movie1=new Movie("3 Idiots",200,"Movie","Rajkumar Hirani");
        movie1.display_info();
        System.out.println("-------------------------");

        MusicAlbum alubm1=new MusicAlbum("Kahani Suno",100,"Music","Kaifi Khalil");
        alubm1.display_info();
        System.out.println("-------------------------");
        
    }
}
