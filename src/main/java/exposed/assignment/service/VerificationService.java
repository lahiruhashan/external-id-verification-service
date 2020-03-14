package exposed.assignment.service;

import exposed.assignment.util.LicenceType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

@Service
public class VerificationService {
    public boolean verifyFromCSV(String licenceId) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        URL resource = classLoader.getResource("dmv.csv");
        if (resource != null) {
            file = new File(resource.getFile());
        }
        if (file != null) {
            BufferedReader csvReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[1].equals(licenceId)) {
                    return !data[2].equalsIgnoreCase(LicenceType.SUSPENDED.name());
                }
            }
            csvReader.close();
        }
        return false;
    }
}
