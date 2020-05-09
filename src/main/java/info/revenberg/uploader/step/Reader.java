package info.revenberg.uploader.step;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import info.revenberg.uploader.objects.DataObject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import info.revenberg.uploader.service.BatchService;

public class Reader implements ItemReader<DataObject> {
    @Autowired
    private BatchService batchService;

	private File folder = null;
	List<String> list = new ArrayList<>();

	public static String location = "D:/pptx/";

    public static void search(final String pattern, final File folder, List<String> result, final String pre) {
        Reader reader = new Reader();
        Long count = reader.batchService.getLastReadCount();
        System.out.println(count);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result, pre + f.getName() + "/");
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    if (pre == "") {
                        result.add(location + f.getName());
                    } else {
                        result.add(location +  pre + f.getName());
                    }
                }
            }
        }
    }

	@Override
	public DataObject read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (folder == null) {
			folder = new File(location);
			search(".*", folder, list, "");
	   }

	   if (!list.isEmpty()) {
		   String element = list.get(0);
           list.remove(0);
		   return new DataObject(element);
	   }
	   return null;
   }


}