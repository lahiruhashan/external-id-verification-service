package exposed.assignment.service;

import exposed.assignment.util.LicenceType;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VerificationService {
    public String verifyFromCSV(String licenceId) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/external-files/dmv.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[1].equals(licenceId)) {
                if (data[2].equalsIgnoreCase(LicenceType.SUSPENDED.name())) {
                    return licenceId;
                } else {
                    return LicenceType.ACTIVE.name();
                }
            }
        }
        csvReader.close();

        return null;
    }
}
