package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Long movie_id;
    private String movie_title;
    private String length;
    private Date release_date;
    private String imbd_id;
    private Long genre_id;
    private Long rating_id;
}
