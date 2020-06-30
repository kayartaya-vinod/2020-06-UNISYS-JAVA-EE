package co.vinod.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@Setter
@Getter
public class Supplier {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "supplier_id")
	private Integer supplierId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_title")
	private String contactTitle;

	@Embedded
	private ContactDetails contactDetails;

	private String phone;
	private String fax;
	@Column(name = "home_page")
	private String homePage;

	@OneToMany //(fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id")
	private List<Product> products;
}
