namespace AnimeList.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Anime
    {
        [Key]
        public int Id { get; set; }

        [Required]
        public int Rating { get; set; }

        [Required]
        public string Name { get; set; }

        [Required]
        public string Description { get; set; }

        [Required]
        public string Watched { get; set; }
    }
}