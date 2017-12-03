namespace BookLibrary.Models
{
    public class Book
    {
        public int Id { get; set; }

        public string Title { get; set; }

        public string Desciption { get; set; }

        public string AuthorId { get; set; }

        public ApplicationUser Author { get; set; }
    }
}