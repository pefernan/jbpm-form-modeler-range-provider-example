package org.jbpm.formModeler.examples.range;

import org.jbpm.formModeler.api.model.RangeProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProductRangeProvider implements RangeProvider {
    @Override
    public String getType() {
        return "{productList}";
    }

    @Override
    public Map<String, String> getRangesMap(String namespace) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(ProductRangeProvider.class.getResourceAsStream("products.csv")));

        Map<String, String> maps = new HashMap<String, String>();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values != null && values.length == 2) {
                    maps.put(values[0], values[1]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return maps;
    }

}
