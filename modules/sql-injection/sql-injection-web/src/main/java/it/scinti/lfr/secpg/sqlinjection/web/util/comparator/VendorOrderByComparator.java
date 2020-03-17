package it.scinti.lfr.secpg.sqlinjection.web.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;

public class VendorOrderByComparator extends OrderByComparator<Vendor> {
	private static final long serialVersionUID = 1L;

	private boolean ascending;
	private String columnName;

	public static OrderByComparator<Vendor> getVendorOrderByComparator(String columnName, boolean ascending) {
		return new VendorOrderByComparator(columnName, ascending);
	}

	public boolean isAscending() {
		return this.ascending;
	}

	private VendorOrderByComparator(String columnName, boolean ascending) {
		super();
		this.ascending = ascending;
		this.columnName = columnName;
	}

	public String[] getOrderByFields() {
		return new String [] { this.columnName };
	}

	public String getOrderBy() {
		return this.columnName + " " + (this.ascending ? "asc" : "desc");
	}

	@Override
	public int compare(Vendor o1, Vendor o2) {
		return o1.compareTo(o2);
	}

}
