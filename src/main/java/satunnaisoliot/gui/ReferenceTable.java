
package satunnaisoliot.gui;

import java.util.List;
import java.util.Locale;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import satunnaisoliot.structs.dao.Dao;
import satunnaisoliot.structs.enums.FieldType;
import satunnaisoliot.structs.enums.ReferenceType;
import satunnaisoliot.structs.interfaces.Reference;

public class ReferenceTable extends AbstractTableModel {

    private Dao dao;
    private static final String[] dbColumns = {
        "reference_type",
        "bibtex_key",
//      "address",
//      "annote",
        "author",
        "booktitle",
//      "chapter",
//      "crossref",
//      "edition",
        "editor",
//      "howpublished",
//      "institution",
        "journal",
        "bibkey",
//      "month",
//      "note",
//      "number",
//      "organization",
//      "pages",
        "publisher",
//      "school",
//      "series",
        "title",
//      "type",
//      "volume",
        "year",
    };

    // This can be used to have one set of column names for accessing the
    // reference data, and another set of names to display to the user.
    // The order 0f both arrays has to remain the same.
    private static final String[] guiColumns = {
        "Type",
        "Key",
//      "Publisher's address",
//      "Annotation",
        "Author",
        "Book title",
//      "Chapter",
//      "Crossref key",
//      "Edition",
        "Editor",
//      "How published",
//      "Institution",
        "Journal",
        "Sort as",
//      "Month",
//      "Note",
//      "Number",
//      "Organization",
//      "Pages",
        "Publisher",
//      "School",
//      "Series",
        "Title",
//      "Type",
//      "Volume",
        "Year",
    };

    List<Reference> referenceList;

    public ReferenceTable(Dao dao) {
        this.dao = dao;
        updateReferenceList();
    }

    public void updateReferenceList() {
        this.referenceList = dao.findAll();
    }

    @Override
    public int getRowCount() {
        return dao.rowcount();
    }

    @Override
    public int getColumnCount() {
        return dbColumns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        //return dbColumns[columnIndex];
        return guiColumns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // screw it for now
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reference ref = referenceList.get(rowIndex);
        String fieldToGet = dbColumns[columnIndex];

        if (fieldToGet.equals("reference_type")) {
            ReferenceType reftype = ref.getType();
            return reftype.toString();
        } else if (fieldToGet.equals("bibtex_key")) {
            return ref.getBibTexKey();
        } else if (fieldToGet.equals("bibkey")) {
            FieldType ft = FieldType.valueOf("KEY");
            return ref.getField(ft);
        } else {
            String fieldNameAsEnumName = fieldToGet.toUpperCase(Locale.ROOT);
            FieldType ft = FieldType.valueOf(fieldNameAsEnumName);
            String fieldValue = ref.getField(ft);
            return fieldValue;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
