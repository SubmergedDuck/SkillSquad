package app;

import entity.Users.CommonUserFactory;
import entity.Users.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_event.CreateEventController;
import interface_adapter.generate_static_map.GenerateStaticMapController;
import interface_adapter.generate_static_map.GenerateStaticMapViewModel;
import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.my_event.MyEventViewModel;
import interface_adapter.search_nearby.SearchNearbyController;
import interface_adapter.search_nearby.SearchNearbyViewModel;
import use_case.loggedIn.LoggedInUserDataAccessInterface;
import use_case.loggedIn.LoggedInInputBoundary;
import use_case.loggedIn.LoggedInInteractor;
import use_case.loggedIn.LoggedInOutputBoundary;
import use_case.search_nearby.SearchNearbyDataAccessInterface;
import view.HomeView;


import javax.swing.*;
import java.io.IOException;

public class LoggedInUseCaseFactory {
    private LoggedInUseCaseFactory(){

    }
    public static HomeView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            SearchNearbyViewModel searchNearbyViewModel,
            LoginViewModel loginViewModel,
            LoggedInUserDataAccessInterface userDataAccessInterface,
            SearchNearbyDataAccessInterface searchNearbyDataAccessObject,
            CreateEventController createEventController,
            GenerateStaticMapController generateStaticMapController,
            GenerateStaticMapViewModel generateStaticMapViewModel,
            MyEventViewModel myEventViewModel) {
        try{
            LoggedInController loggedInController = createLoggedInUseCase(viewManagerModel,loggedInViewModel, loginViewModel, myEventViewModel,userDataAccessInterface);
            SearchNearbyController searchNearbyController = SearchNearbyUseCaseFactory.createSearchNearbyUseCase(viewManagerModel, searchNearbyViewModel, searchNearbyDataAccessObject);
            return new HomeView(loggedInViewModel,loggedInController, searchNearbyController, createEventController,generateStaticMapController,generateStaticMapViewModel, myEventViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;

    }

    private static  LoggedInController createLoggedInUseCase(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            LoginViewModel loginViewModel,
            MyEventViewModel myEventViewModel,
            LoggedInUserDataAccessInterface userDataAccessInterface
    ) throws IOException{
        LoggedInOutputBoundary loggedInOutputBoundary = new LoggedInPresenter(viewManagerModel,loggedInViewModel,loginViewModel,myEventViewModel);
        UserFactory userFactory = new CommonUserFactory();

        LoggedInInputBoundary loggedInInteractor = new LoggedInInteractor(userDataAccessInterface, loggedInOutputBoundary);

        return new LoggedInController(loggedInInteractor);
    }
}
