package se.mtiasp.foodfavorites.model.api;

import javax.inject.Singleton;
import dagger.Component;
import se.mtiasp.foodfavorites.model.SearchRepository;

@Singleton
@Component(modules = { ApiServiceModule.class })
public interface ApiServiceComponent {
    void inject(SearchRepository searchRepository);
}
