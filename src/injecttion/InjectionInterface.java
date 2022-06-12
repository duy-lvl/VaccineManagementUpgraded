/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injecttion;

/**
 *
 * @author DuyLVL
 */
public interface InjectionInterface {

    public void readFromFile(String fileName);

    public boolean writeToFileOut(String fileName);

    public boolean writeToFileIn(String fileName);

    public void addInjectionInformation(String studentList, String vaccineList);

    public void updateInjectionInformation();

    public void deleteInjection();

    public void searchByStudentID();

    public void searchByStudentName();
}
