package tw.idv.petpet.web.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "article_favorites")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFavorites {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_article_number")
    private int favoriteArticleNumber;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "collection_time")
    private Date collectionTime;
}
