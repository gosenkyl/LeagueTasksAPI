package com.gosenk.league.tasks.api;

import com.gosenk.league.tasks.api.model.Champion;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

public final class GetNewChampionInfo {

    public static void main(String[] args){

        try{
            InputStream is = new URL("http://ddragon.leagueoflegends.com/cdn/6.5.1/data/en_US/champion.json").openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);

                JSONObject arr = json.getJSONObject("data");

                Iterator<String> keys = arr.keys();
                List<String> insertStatements = new ArrayList<String>();
                while(keys.hasNext()){
                    String key = keys.next();
                    JSONObject val = (JSONObject) arr.get(key);

                    Champion champ = createChampion(val);
                    // Store Champion via Hibernate
                    // Temporary, Generate Insert Statements

                    insertStatements.add(generateInsert(champ));
                }

                writeInsertStatements(insertStatements);

            } finally {
                is.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void writeInsertStatements(List<String> inserts){
        try{

            File file = new File("champion.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(String insert : inserts) {
                bw.write(insert);
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateInsert(Champion champ){
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO CHAMPION VALUES (");
        sb.append(quoteWrap(champ.getId()) + ",");
        sb.append(quoteWrap(champ.getKey().toString()) + ",");
        sb.append(quoteWrap(champ.getName()) + ",");
        sb.append(quoteWrap(champ.getTitle()) + ",");
        sb.append(quoteWrap(champ.getImage()));
        sb.append(");");

        return sb.toString();
    }

    private static String quoteWrap(String str){
        return "'" + str.replace("'","''") + "'";
    }

    private static Champion createChampion(JSONObject obj){
        Champion champion = new Champion();
        champion.setId((String) obj.get("id"));
        champion.setKey(Long.parseLong((String) obj.get("key")));
        champion.setName((String) obj.get("name"));
        champion.setTitle((String) obj.get("title"));

        JSONObject img = (JSONObject) obj.get("image");
        champion.setImage((String) img.get("full"));

        return champion;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
