package com.sebbia.testtask.news;

import com.sebbia.testtask.base.response.ListResponse;
import com.sebbia.testtask.error.exception.ObjectNotFoundException;
import com.sebbia.testtask.utils.Transactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Transactional
@Api(
        value = "v1/news/",
        description = "Получение категорий и новостей"
)
public class NewsController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = "/v1/news/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение списка категорий", notes = "Возвращает все категории сразу, без пейджинга")
    public ListResponse categories() {
        ListResponse<CategoryDto> listResponse = new ListResponse<>();
        listResponse.fillWithDto(CategoryDto.class, Category.class, categoryRepository.findAll());
        return listResponse;
    }

    @RequestMapping(value = "/v1/news/categories/{id}/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение списка новостей", notes = "Возвращает список новостей в указанной категории, в коротком виде (без полного текста), с пейджингом (размер страницы - 10)")
    public ListResponse newsList(
            @PathVariable Long id,
            @ApiParam(value = "Номер страницы")
            @RequestParam(required = false)
            Integer page
    ) throws ObjectNotFoundException {
        Category category = categoryRepository.findOne(id);
        if (category == null) {
            throw new ObjectNotFoundException(Category.class, id);
        }

        int pageNumber = 0;
        if (page != null) {
            pageNumber = page;
        }

        PageRequest pageRequest = new PageRequest(pageNumber, 10, new Sort("date"));
        ListResponse<NewsDtoShort> listResponse = new ListResponse<>();
        listResponse.fillWithDto(NewsDtoShort.class, News.class, newsRepository.findByCategory(category, pageRequest));
        return listResponse;
    }

    @RequestMapping(value = "/v1/news/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получение новости со всеми подробностями", notes = "Возвращает полную информацию о выбранной новости")
    public NewsResponse details(
            @ApiParam(value = "Id новости")
            @RequestParam(required = false)
            Long id
    ) throws ObjectNotFoundException {
        News news = newsRepository.findOne(id);
        if (news == null) {
            throw new ObjectNotFoundException(News.class, id);
        }

        return new NewsResponse(news);
    }

}
