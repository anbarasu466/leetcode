package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindManagers {
    public static void main(String Args[]){
        HashMap<Character,Character> employeeToManagerMappings = new HashMap<Character,Character>();
        employeeToManagerMappings.put('A', 'A');
        employeeToManagerMappings.put('B', 'A');
        employeeToManagerMappings.put('C', 'B');
        employeeToManagerMappings.put('D', 'B');
        employeeToManagerMappings.put('E', 'D');
        employeeToManagerMappings.put('F', 'E');

        findEmployees(employeeToManagerMappings);

    }

    public static void findEmployees(HashMap<Character,Character> employeeToManagerMappings){
        HashMap<Character, List<Character>> managerToEmployeeMappings = new HashMap<>();

        for (var entry: employeeToManagerMappings.entrySet()){
            char employee = entry.getKey();
            char manager = entry.getValue();

            if(employee != manager){
                managerToEmployeeMappings.putIfAbsent(manager, new ArrayList<>());
                managerToEmployeeMappings.get(manager).add(employee);
            }
        }

        for (var  entry: employeeToManagerMappings.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("************************************************************");

        HashMap<Character,List<Character>> result = new HashMap<>();

        for (var  entry: managerToEmployeeMappings.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        int i=0;
        for(var entry : employeeToManagerMappings.entrySet()){
            System.out.println(i++ + "  " + entry.getKey());
            findAllReportingEmployees(entry.getKey(),managerToEmployeeMappings,result);
        }

        System.out.println("************************************************************");
        // print contents of the result map
        for (var  entry: result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }

    public static  List<Character> findAllReportingEmployees(Character manager, HashMap<Character, List<Character>> managerToEmployeeMappings, HashMap<Character, List<Character>> result){
        if(result.containsKey(manager)){
            return result.get(manager);
        }

        List<Character> managerEmployees = managerToEmployeeMappings.get(manager);


        if (managerEmployees != null)
        {
            for (char reportee : new ArrayList<>(managerEmployees)) {

                List<Character> employees = findAllReportingEmployees(reportee,managerToEmployeeMappings, result);

                if (employees != null) {
                    managerEmployees.addAll(employees);
                    managerEmployees.forEach(key -> System.out.println(manager + "  " +key));

                }
            }
        }

        result.put(manager, managerEmployees);
        return managerEmployees;

    }
}
