
import com.editor.filters.ColorFilter;
import com.editor.filters.Filter;

import com.editor.filters.SharpenFilter;
import com.editor.repository.ImageRepository;

import com.editor.repository.SqlImageRepository;
import com.editor.service.ImageEditor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Editor
        ImageEditor editor = new ImageEditor();

        // 2. Capture an image (SRP: Editor handles high-level flow)
        editor.clickImage();

        // 3. Apply Filters (OCP: We can pass any implementation of Filter)
        Filter sharpen = new SharpenFilter();
        editor.applyFilter(sharpen);

        Filter blueFilter = new ColorFilter("Blue");
        editor.applyFilter(blueFilter);

        // 4. Save the Image (OCP/DIP: Save to any repository type)
        ImageRepository sqlRepo = new SqlImageRepository();
        editor.save(sqlRepo);

        editor.applyFilter(new ColorFilter("Sepia"));
    }
}