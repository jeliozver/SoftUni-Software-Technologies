namespace BookLibrary.Models
{
    public class Book
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string Desciption { get; set; }

        public string Author { get; set; }

        public string UserId { get; set; }

        public ApplicationUser User { get; set; }
    }
}