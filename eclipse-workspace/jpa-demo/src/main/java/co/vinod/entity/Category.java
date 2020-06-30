package co.vinod.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"products"})
public class Category {
	@Id
	@Column(name = "category_id")
	@GeneratedValue(generator = "increment")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	private String description;
	private byte[] picture;

	@OneToMany // (mappedBy = "category")
	@JoinColumn(name = "category_id")
	private List<Product> products;
}
